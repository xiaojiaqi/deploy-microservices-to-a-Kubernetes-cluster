package proxy


import (

	"fmt"
	"net"
	"os"
)

func Run_tcp_service(localport string,  remoteport string ) {


	var l net.Listener
	var err error
	l, err = net.Listen("tcp",   localport)
	if err != nil {
		fmt.Println("Error listening:", err)
		os.Exit(1)
	}
	defer l.Close()
	fmt.Println("Listening on "  + localport)
	for {
		connFromClient, err := l.Accept()
		if err != nil {
			fmt.Println("Error accepting: ", err)
			os.Exit(1)
		}
		//logs an incoming message
		fmt.Printf("Received message %s -> %s \n", connFromClient.RemoteAddr(), connFromClient.LocalAddr())
		// Handle connections in a new goroutine.
		go handleRequest(connFromClient,remoteport)
	}



}

func  handleRequest(connFromClient net.Conn, remoteport string) {
	connToServer, err := net.Dial("tcp", remoteport)
	if err != nil {
		fmt.Println("Error connecting:", err)
		return
	}



	go pipe(connToServer, connFromClient)
	pipe(connFromClient, connToServer )


}

func pipe(connFromClient , connToServer net.Conn){

	defer connFromClient.Close()
	defer connToServer.Close()

	buff:= make([] byte, 1024)
	for {
		read_n, readerr := connFromClient.Read(buff)
		if readerr != nil {
			return
		}
		if read_n < 0 {
			break;
		}

		// Write writes data to the connection.
		// Write can be made to time out and return an Error with Timeout() == true
		// after a fixed time limit; see SetDeadline and SetWriteDeadline.
		write_n, writeerr := connToServer.Write(buff [0: read_n] )
		if writeerr != nil {
			return
		}
		if write_n < 0 {
			break;
		}
	}
}

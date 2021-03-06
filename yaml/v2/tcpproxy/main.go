package main


import (
	"flag"
	"fmt"
	_ "go.uber.org/automaxprocs"
	"tcpproxy/proxy"
)

var l = flag.String("l", "8080", "本地端口 比如 8080")
var r = flag.String("r", "www.k8seasy.com:80", "远端域名  将把远端域名和端口 比如 www.k8seasy.com:80 端口映射到本地， 主要用于pod 端口映射")
var _ = ""
func main (){

		flag.Parse()

    fmt.Println("将把 " + *r + " ==》　 本地端口 " +  "0.0.0.0:"+ *l)

	proxy.Run_tcp_service("0.0.0.0:"+*l,  *r)

}


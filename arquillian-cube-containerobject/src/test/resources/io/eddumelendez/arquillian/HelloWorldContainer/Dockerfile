FROM golang:1.7.1

RUN mkdir -p /go/src/app

WORKDIR /go/src/app

COPY server.go /go/src/app

EXPOSE 8080

CMD ["go", "run", "server.go"]
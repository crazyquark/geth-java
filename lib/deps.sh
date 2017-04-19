#!/bin/bash
go get github.com/sridharv/gojava

pushd $GOPATH
mkdir -p github.com/ethereum
pushd github.com/ethereum
git clone git@github.com:ethereum/go-ethereum.git
git checkout v1.5.9
make
popd
popd



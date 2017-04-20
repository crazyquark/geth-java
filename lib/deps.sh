#!/bin/bash
go get github.com/sridharv/gojava

CRT_DIR=`pwd`

pushd $GOPATH
mkdir -p src/github.com/ethereum
pushd src/github.com/ethereum

if [ ! -d go-ethereum ]
then
	git clone git@github.com:ethereum/go-ethereum.git
	pushd go-ethereum
	git checkout v1.5.9
	popd
fi

# Patch out light mode
pushd go-ethereum
cp $CRT_DIR/no_light.patch .
git reset --hard
git apply no_light.patch
popd

popd
popd



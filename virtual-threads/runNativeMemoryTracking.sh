#!/usr/bin/env bash

#make sure the util module is compiled before running this script
#you can tune stack size with -XX:ThreadStackSize=$size

threadCount=${1:-1}
threadType=${2:-'PLATFORM'}
jcmd=${3:-'false'}

java -cp ../util/target/classes/ -XX:NativeMemoryTracking=summary \
-XX:StartFlightRecording=name=Profiling,filename=nmtRecording.jfr,settings=profile \
-XX:NativeMemoryTracking=detail \
src/main/java/org/jugistanbul/virtualthread/monitor/NativeMemoryTracking.java \
$threadCount $threadType $jcmd

jfr print --events jdk.NativeMemoryUsage nmtRecording.jfr
jfr print --events jdk.NativeMemoryUsageTotal nmtRecording.jfr
jfr view native-memory-reserved nmtRecording.jfr
jfr view native-memory-committed nmtRecording.jfr



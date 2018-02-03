#!/bin/bash
set -x
spark=/TOOLS/software/spark-1.5.0-bin-hadoop2.6/bin/spark-submit
class=cn.i.spark.ml.cf.MovieLensALS
jar=`dirname $0`"/../target/ISpark-ML-0.0.1-SNAPSHOT-package.jar"
data=`dirname $0`"/../data/ml-latest-small"
#$spark --driver-java-options="-agentlib:jdwp=transport=dt_socket,address=9904,server=y,suspend=y"  --class  $class   $jar
hbase=/TOOLS/software/hbase-1.1.2/lib/
phoenix=/TOOLS/software/phoenix-4.5.2-HBase-1.1-bin/
for i in `ls $hbase`; do x+="$hbase$i,"; done; 
jars=$x
$spark  --class  $class --jars $jars $jar \
--rank 10 --maxIter 15 --regParam 0.1 \
--movies $data/movies.pre.txt \
--ratings $data/ratings.pre.txt

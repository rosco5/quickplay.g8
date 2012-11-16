git init . && git add . && git commit -m "init"  
export HOPTS=='-Xms384m -Xmx384m -Xss1M -XX:MaxPermSize=512M -XX:+UseCompressedOops -javaagent:heroku-javaagent-1.2.jar=stdout=true -XX:+PrintGCDetails -XX:+PrintHeapAtGC -XX:+PrintGCDateStamps  -XX:+CMSClassUnloadingEnabled'
heroku create  --buildpack https://github.com/blendlabs/heroku-buildpack-scala
heroku config:add JAVA_OPTS=$HOPTS
heroku config:add SBT_OPTS=$HOPTS
heroku config:add BUILDPACK_URL=https://github.com/blendlabs/heroku-buildpack-scala

i=0
while [ "$i" -lt "60" ]                                                                                                                                         
do
  echo "$i"
  var=$(curl -Is http://localhost:9000 | head -n 1)
  var="HTTP/1.1 200 OK"
  
  if [ -n "$var" ]; then
      var=$(pwd)

      export PATH=$PATH:$var
      echo $PATH
      
      mvn test

      export PATH=${PATH%:$var}
      echo $PATH
      i=60
  else
      echo "Server is NOT up"
      i=$[$i+1]
      sleep 1
  fi 

done
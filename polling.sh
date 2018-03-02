i=0
while [ "$i" -lt "60" ]                                                                                                                                         
do
  echo "$i"
  var=$(curl -Is http://localhost:9000 | head -n 1)

  if [ -n "$var" ]; then
      mvn test
      i=60
  else
      echo "Server is NOT up"
      i=$[$i+1]
      sleep 1
  fi 

done
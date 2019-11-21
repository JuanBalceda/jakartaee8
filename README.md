# jakartaee8
Jakarta EE 8 Recipes - Demo Project

# Servlets 4.0
## Setup HTTPS (http/2)

Generate keystore
```sh
$ keytool -genkey -keyalg RSA -alias jakartaee -keystore jakartaee.jks -storepass jakartaee -validity 360 -keysize 1048
```

Export certificate
```sh
$ keytool -export -alias jakartaee -keystore jakartaee.jks -rfc -file jakartaee_cert.cer
```

Import certificate
```sh
$ keytool -import -cacerts -trustcacerts -alias jakartaee -file jakartaee_cert.cer
```
## Note
> Move `jakartaee.jks` and `jakartaee_cert.cer` to TomEE "conf/" directory 

Update server.xml
```xml
<Connector port="8443" protocol="org.apache.coyote.http11.Http11NioProtocol"
    maxThreads="150" keystoreFile="conf/jakartaee.jks"
    keystorePass="jakartaee" scheme="https" secure="true"
    clientAuth="false" SSLEnabled="true" sslProtocol="TLS">
    <UpgradeProtocol className="org.apache.coyote.http2.Http2Protocol"/>
</Connector>
```
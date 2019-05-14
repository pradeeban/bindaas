# Bindaas Data Integration Middleware Platform
[![Build Status](https://travis-ci.com/pradeeban/bindaas.svg?branch=master)](https://travis-ci.org/pradeeban/bindaas)

## Building Bindaas

Bindaas can be built using Apache Maven 3.x and Java 1.7.x or higher.

 $ mvn clean install

Bindaas binaries can be found in the binaries folder.

Built and tested with Apache Maven 3.1.1 to 3.5.4 and Oracle Java 1.7 to 1.8.

Bindaas does not build with JDK 10, due to incompatibilities in Maven plugins.


## Executing Bindaas

Once you have successfully built Bindaas, you will find the binary in a compressed format, as in
bindaas-dist-2.0.7-201806281144-min.tar.gz


Extract this compressed binary. Now bindaas-dist-2.0.7-201806281144-min will be your <BINDAAS-BINARY-HOME>.

Bindaas can be executed using the startup.sh script in
<BINDAAS-BINARY-HOME>/bin

$ sh startup.sh

Similarly, you may shut down Bindaas by executing the shutdown script:

$ sh shutdown.sh

If you would like to have an interactive OSGi console with logs displayed inline:

$ java -Dpid=BINDAAS_INSTANCE -Xmx1024m -jar org.eclipse.osgi_3.8.2.v20130124-134944.jar -console


## Troubleshooting

If you encounter the error "java.net.SocketException: Can't assign requested address" followed by a few
CXF errors when you are on a Mac with a wireless connection, please use the flag "-Djava.net.preferIPv4Stack=true" to fix this,
as shown below:

$ java -Djava.net.preferIPv4Stack=true -Dpid=BINDAAS_INSTANCE -Xmx1024m -jar org.eclipse.osgi_3.8.2.v20130124-134944.jar -console


## Verify Setup

To verify everything is setup correctly visit the following url in your web-browser :
http://localhost:8080/dashboard/

You should be greeted by Bindaas' Login page.

The logs can be found at <BINDAAS-BINARY-HOME>/log/bindaas.log.


## Log in to Bindaas Management Console

Log in using the default,
user name: admin
password: password



More details on configuring Bindaas can be found from the [admin guide](https://github.com/sharmalab/bindaas/wiki/Bindaas-Admin-Guide).

If you prefer to run Bindaas using its Docker container, please refer to [docker/README.md](docker/README.md) for more details.

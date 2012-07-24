Run sql queries over an ssh tunnel.
===================

In some scenarios the database may not be directly accessible. But is available via a hop server.

To use this piece of code following needs to be done
* Configure database password in jvm. Property name should be `dbPassword`
* Configure ssh host password in jvm. Property name should be `sshHostPassword`
* Configure database properties as case objects in `com.charandeepmatta.dbtunnel`.
* Define ssh server config in `com.charandeepmatta.dbtunnel.SshConnectionConfig`.


sql-over-ssh-tunnel
===================

Sample code to run sql queries via ssh-tunnel to a target database

To use this piece of code following needs to be done
1. Configure database password in jvm. Property name should be "dbPassword"
2. Configure ssh host password in jvm. Property name should be "sshHostPassword"
3. Configure database properties as case objects in com.charandeepmatta.dbtunnel .
4. Define ssh server config in com.charandeepmatta.dbtunnel.SshConnectionConfig


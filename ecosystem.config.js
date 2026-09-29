module.exports = {
  apps: [
    {
      name: "class-service",
      script: "java",
      args: "-jar class-service.jar",
      cwd: "/opt/pulsefit/class-service",
      env: {
        SERVER_PORT: "8082",
        CONFIG_SERVER_URL: "http://localhost:8888",
        EUREKA_SERVER_URL: "http://localhost:8761/eureka",
        DB_HOST: "<CLOUD_SQL_PRIVATE_IP>",
        DB_PORT: "3306",
        DB_NAME: "pulsefit_class_db",
        DB_USERNAME: "<DB_USERNAME>",
        DB_PASSWORD: "<DB_PASSWORD>"
      },
      autorestart: true,
      max_restarts: 10,
      min_uptime: "10s",
      restart_delay: 3000,
      out_file: "/var/log/pm2/class-service-out.log",
      error_file: "/var/log/pm2/class-service-error.log",
      log_date_format: "YYYY-MM-DD HH:mm:ss"
    }
  ]
};

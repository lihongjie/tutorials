package com.example;

@EnableMuleConfiguration
@SpringBootApplication
public class MuleApplication {

    private static final Logger logger = LoggerFactory.getLogger(DemoMuleSpringBootApplication.class);

    @Autowired
    private ApplicationContext context;

    public static void main(String... args) {
        logger.info("Starting SpringApplication...");
        SpringApplication app = new SpringApplication(DemoMuleSpringBootApplication.class);
        app.setBannerMode(Banner.Mode.CONSOLE);
        app.setWebEnvironment(false);
        app.run();
        logger.info("SpringApplication has started...");
    }
}

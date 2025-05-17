# Spring I/O - Testcontainers and WireMock Workshop

Shows a TODO list that also allows loading top stories for reading from Hackernews...
and also loading them from a [WireMock](https://wiremock.org/) mock API
running in [Testcontainers](https://www.testcontainers.org/).

## Prerequisites

* Docker Desktop or another Testcontainers-enabled engine

## Getting Started

### Local database

1. Clone this repository or download and unzip it.
2. Run the database with `docker compose up`
3. Run application locally with `./gradlew bootRun`
4. Open the application in the browser: [link](http://localhost:8080/?http://localhost:8080/todos)
5. Click the _What's up on Hackernews?_ to see what new get loaded for your reading list!

### Now with Testcontainers in dev environment
 
3. Run application locally letting Spring Boot and Testcontainers set up a database for it: `./mvnw spring-boot:test-run`

P.S Check out the `ContainersConfig` class to see how elegant the Spring Boot and Testcontainers integration is now.

### Screenshot

Demo app after loading Hacker News best stories from the WireMock container:

![Demo Web UI](./docs/images/ui_screenshot.png)

## References

- [Video from the Devoxx BE talk](https://www.youtube.com/watch?v=eFILbyaMI2A) - see the _Mega Demo_ part for this demo (from ~30:00)
- [Slides from the Devoxx BE 2023 talk](https://docs.google.com/presentation/d/e/2PACX-1vQSgTTCg-LkmrL-5UuAE63zxuWP0kADBetXXBqMVO-oEQWfP6zGu16eFSdKxvEbchDnaCwKZ2a7134F/pub?start=false&loop=false&delayms=3000)
- [WireMock Module for Testcontainers](https://testcontainers.com/modules/wiremock/)
- [HackerNews Mock API](https://library.wiremock.org/catalog/api/y/ycombinator.com/hackernews_v0/) on the
  [WireMock API Templates Library](https://library.wiremock.org/)

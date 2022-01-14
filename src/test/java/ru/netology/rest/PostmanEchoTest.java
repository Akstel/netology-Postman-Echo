package ru.netology.rest;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class PostmanEchoTest {
    @Test
    void shouldReturnData() {
        // Given - When - Then
        // Предусловия
        ValidatableResponse some_data = given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("some data" + " Мы Вас приветствуем!") // отправляемые данные (заголовки и query можно выставлять аналогично)
                // Выполняемые действия
                .when()
                .post("/post")
                // Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("some data"  + " Мы Вас приветствуем!"));
    }
}

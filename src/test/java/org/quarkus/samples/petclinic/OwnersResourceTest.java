package org.quarkus.samples.petclinic;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.quarkus.samples.petclinic.system.ErrorExceptionMapper.ERROR_HEADER;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;

import org.junit.jupiter.api.Test;
import org.quarkus.samples.petclinic.owner.OwnersResource;

@QuarkusTest
@TestHTTPEndpoint(OwnersResource.class)
public class OwnersResourceTest {

    @Test
    @TestSecurity(authorizationEnabled = false)
    void findPage() {
        when().get("find").then()
                .statusCode(200)
                .header(ERROR_HEADER, is(nullValue()));
    }

    @Test
    @TestSecurity(authorizationEnabled = false)
    void findAll() {
        when().get("?lastName=").then()
                .statusCode(200)
                .header(ERROR_HEADER, is(nullValue()));

    }

    @Test
    @TestSecurity(authorizationEnabled = false)
    void existingOwner() {
        when().get("1001").then()
                .statusCode(200)
                .header(ERROR_HEADER, is(nullValue()));

    }

    @Test
    @TestSecurity(authorizationEnabled = false)
    void invalidOwner() {
        when().get("1").then()
                .statusCode(200)
                .header(ERROR_HEADER, is(notNullValue()));

    }
}

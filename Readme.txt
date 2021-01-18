distance-calculator-service: Service which provides the following functionalities:

  - get distance between two zip codes
    http://localhost:8080/locations/distance/{zipCode1}/{zipCode2}
    zipCode should be in format like: BR5 4BN. It is validated by regular expression.

  - get postCode information(longitude, latitude) by code
    http://localhost:8080/locations/{zipCode1}
    zipCode should be in format like: BR5 4BN. It is validated by regular expression.

  - update data of PostCode
    http://localhost:8080/locations/{id}

Configuration of PostgreSql:

datasource.url=jdbc:postgresql://localhost:5432/uk_postcodedb
datasource.username=postgres
datasource.password=Nana1212

there are 2 tables with data:

"postcodelatlng" with data from: http://www.freemaptools.com/download/full-postcodes/postcodes.zip
"user": id - 1
        active - true
        roles - USER_ROLE
        user_name - root
        password - $2y$12$kcQVnF/SRcRijF8NujnXX.4t1SB.ixWK3rIWZMJ/dZD2R.NDUJn1u (encrypted text 'pass' by BCrypt)

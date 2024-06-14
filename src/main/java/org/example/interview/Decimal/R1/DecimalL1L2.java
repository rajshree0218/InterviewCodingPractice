package org.example.interview.Decimal.R1;

public class DecimalL1L2 {
    public static void main(String[] args) {
        // Q1. diff b/w abstract class & interface
        // Q2. java 8 features
        // q3. coding : group by
        // q4. hibernate n+1 problem
        // q5. Oops concept questions.
        // q6. api gateway,
        // q7. secure microservices.
        // q8. secure api
        // q9. tools used for service discovery
        // q10. how logs are inserted and how it's being stored in kibana.
        // -> kibana is based on index search, you create index and search based on index, it stores data in elastic search db
        // q11. you have 10 users using your api, now it's become 1lac, how you would scale up.
        // q12. how you decide to scale up vertically or horizontanle microservices.
        // q13. you have UI, 4 fields are there. name, email, pan, id. user can make selection,
        // but at least one selection needs to required. how would do dynamic search.
        // -> https://medium.com/@vidishapal/dynamic-db-queries-with-spring-boot-restful-service-5ebe708de213
        // ans : -> using hibernate? query parameter, criteria query. spring data jpa.
        // q14. before calling actual method/implementation in controller, want to add data to log file. how to do that. and : make use of Spring AOP : Before Advice.
        // q15. ELK
        // q16. database connection pool, hikari,
        // q17. how you would pass multiple values in field, -> make use of tokenization, or list. Query param etc
        // q18. what all are way you can communicate b/w microservices
        // -> resttemplate. webclient
        // how you call 3rd party secured api in your microservices?
        //https://stackoverflow.com/questions/50506101/spring-boot-how-to-communicate-between-microservices


        // Q19. how you ensures data pushed to topic in kafka ? -> kafka tool
        // Q19. how you ensures data added in redis?
        // Q20. you are doing batch processing, and after certain point it failed,




        int N = 2;
        for (int i = 0; i < N; i++) {
            System.out.print(fib(i) + " ");
        }

    }

    static int fib(int n)
    {
        if (n <= 1)
            return n;

        return fib(n - 1) + fib(n - 2);
    }

}



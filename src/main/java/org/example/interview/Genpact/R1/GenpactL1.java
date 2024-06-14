package org.example.interview.Genpact.R1;


public class GenpactL1 {
    public static void main(String[] args) {
        // Q1.
        // Q2. Diff b/w sequential stream and parallel stream
        // Q3. diff b/w @RestController & @Controller
        // Q4. what's the isolation level of cassandra
        // Q5. solve using java8
        //Book- id, name, author
        //Author-id, name, age, gender
        //compute the sum of ages of all females authors younger than 25

//        List<Book> library = new ArrayList<>();
//        list.add(new Book("01", "rajshree", new Author("01", "rajshree", 29, "Female")));
//
//        int sumOfAge = library.stream().map(Book::getAuthor).filter(e-> "Female".equalsIgnoreCase(e.getGender()) && e.getAge()<25)
//        .map(Author::getAge).sum();
//
//        list.stream().map(b->b.getAuthor()).filter(a->a.getGender().equals("Female")).collect(Collectors.summingInt(Author::getAge));

        //
        // Q6. Stream.of(1, 2, 3).flatMap(n -> Stream.of(n, n * 2)).forEach(System.out::print); o/p of the program? o/p:122436
        // Q7. how to handle authentication and authorization?
        // Q8. @Secured, @PreAuthorized, @PostAuthorized
        // Q9. what the method name for authorization and authentication, loadByUser()?, loadByPassword()?
        // Q10. diff b/w @Bean and @Component -> component will be scan at componnent scan. and in bean is for configurations.
        // Q11.
        //
    }
}

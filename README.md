# spring security examples

Each commit of this repository is a example that demonstrates the possibilities of working with spring.

#### Example 1. Add web security config class
Demostrate how we can create single user configuration in config class


#### Example 2. Use @secured annotation. 
How can use @Secured annotation for secured methods


#### Example 3. WebSecurityConfig - userDetailsService()
use bean UserDetailsService for create user and store it in memory


#### Example 4. MyUserDetailsService - Hard Coded Users
Simulate work with database. We get the username and match it with the stored data in hashMap


#### Example 5. MyUserDetailsService - Database
shows how to use MyUserDetailsService to retrieve Users/Accounts from Database


#### Example 6. MyUserDetailsService - Database - Profiles with Authorities
shows how to use MyUserDetailsService to retrieve Users/Accounts, Profiles and Authorities from Database


#### Example 7. Add Authorities to Endpoints


#### Example 8. @PreAuthorize - Roles & Authorities
shows how to use @PreAuthorize to add multiple Authorities to single Endpoint for roles and authorities


#### Example 9. antMatchers() - Only check if Authenticated
This example shows how to control access to selected Endpoints depending only if User is Authenticated.
That means ignoring User's Authorities because no Authorities are added to these Endpoints.

#### Example 10. Using custom login and thymeleaf security



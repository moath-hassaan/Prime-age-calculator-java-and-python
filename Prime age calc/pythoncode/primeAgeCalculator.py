import datetime

# Function to check if a number is prime
def is_prime(n):
    if n <= 1: 
        return False  # Numbers less than 2 are not prime numbers
    if n <= 3: 
        return True  # 2 and 3 are prime numbers
    if n % 2 == 0 or n % 3 == 0: 
        return False  # Numbers divisible by 2 or 3 are not prime
    i = 5
    while i * i <= n:  # We only need to check divisibility up to the square root of n
        if n % i == 0 or n % (i + 2) == 0: 
            return False  # If n is divisible by any number, it's not prime
        i += 6
    return True  # If n is not divisible by any number, it's prime

# Function to calculate the next year when the person's age will be a prime number
def next_prime_age_year(birth_year):
    current_year = datetime.date.today().year  # Get the current year
    age = current_year - birth_year  # Calculate the person's current age
    while True:  # Keep looping until we find a prime age
        age += 1  # Increment the age
        if is_prime(age):  # Check if the incremented age is prime
            return birth_year + age  # If it is, return the year when the person will be of that age

if __name__ == "__main__":
    while True:  # Start an infinite loop
        birth_year = input("Please enter your birth year or 'q' to quit: ")  # Ask for input
        if birth_year.lower() == 'q':  # If the user entered 'q' or 'Q', break the loop
            break
        birth_year = int(birth_year)  # Convert the input to an integer
        print("The next year when your age will be a prime number is: ", next_prime_age_year(birth_year))  # Calculate and print the result

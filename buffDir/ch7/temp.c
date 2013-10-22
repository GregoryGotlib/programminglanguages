// gcc -o temp temp.c

int main() {
  typedef int Celsius;
  typedef int Fahrenheit;
  Celsius c=0;
  Fahrenheit f=32;
  f=c;
  // meltdown...
  return 0;
}

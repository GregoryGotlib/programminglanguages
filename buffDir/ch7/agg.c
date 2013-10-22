// gcc -o agg agg.c

#include <stdio.h>

int main() {
  int a[]={10,20,30};
  a[]={10,20,30};		/* illegal */
  a={10,20,30};			/* illegal */
  return 0;
}

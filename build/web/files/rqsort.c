#include<stdio.h>
#include<math.h>
#include<sys/time.h> 
void qsort(int arr[20], int fst, int last)
{
 int i,j,pivot,tmp;
 if(fst<last)
 {
   pivot=fst;
   i=fst;
   j=last;
   while(i<j)
   {
     while(arr[i]<=arr[pivot] && i<last)
        i++;
     while(arr[j]>arr[pivot])
        j--;
     if(i<j)
     {
        tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp; 
     }
   }
   tmp=arr[pivot];
   arr[pivot]=arr[j];
   arr[j]=tmp;
   qsort(arr,fst,j-1);
   qsort(arr,j+1,last);
 }
}
void rqsort(int arr[10000], int fst, int last)
{
 int i,j,pivot,tmp;

 if(fst<last)
 {
   pivot=fst;
   i=fst;
   j=last;
   while(i<j)
   {
     while(arr[i]<=arr[pivot] && i<last)
        i++;
     while(arr[j]>arr[pivot])
        j--;
     if(i<j)
     {
        tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp; 
     }
   }
   tmp=arr[pivot];
   arr[pivot]=arr[j];
   arr[j]=tmp;
   rqsort(arr,fst,j-1);
   rqsort(arr,j+1,last);
 }

}

int main()
{

  long timedif;
			struct timeval tpstart;
			struct timeval tpend;
			struct timeval now;
		        int rc;
	int array[10000], n, c, d, swap,i,j;		
			now.tv_sec=000000000;
			now.tv_usec=000000;
			rc=settimeofday(&now, NULL);
	
			


			if(rc==0) 
				printf("settimeofday() failed.\n");
				
			else 
			{
				//printf("\nsettimeofday() Succesful\n");
				printf("\nTime Set sec=%ld Msec=%ld\n",now.tv_sec,now.tv_usec);
			}
		
			gettimeofday(&tpstart, NULL);
			printf("\nBefore Function call sec=%ld Msec=%ld\n",tpstart.tv_sec,tpstart.tv_usec);

  
gettimeofday(&tpend, NULL);
for(n=0;n<10000;n++)
{
array[n]=n;//rand()%30;
}
i=rand()%10000+1;
j=array[0];
array[0]=array[i];
array[i]=j;
rqsort(array,0,9999);
			
/*for(n=0;n<20;n++)
{
	printf("%d ",array[n]);
}
qsort(array,0,19);
*/			printf("After Function call sec=%ld Msec=%ld\n",tpend.tv_sec,tpend.tv_usec);

		
	
			
			timedif = 1000000 * (tpend.tv_sec - tpstart.tv_sec) + tpend.tv_usec - tpstart.tv_usec;

			

			printf("\nTime difference is:%ld\n",timedif);
  return 0;
}

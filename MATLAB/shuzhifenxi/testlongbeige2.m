clc;clear;
%%%%%%%%%%%%%%%%%%%%%
T1=zeros(9,9);
a=1;b=3;dx=1e-5;
n=1;h=(b-a)/2;
T1(1,1)=h*(f1(a)+f1(b));count=1;
%%%%%%%%%%%%%%%%%%%%%

Fsum=0;count=count+1;
%%%%%%%%count==2%%%%%%%
for ii=1:n
    Fsum=Fsum+f1(a+(2*ii-1)*h);    
end
T1(count,1)=T1(count-1,1)/2+h*Fsum;
%%%%%%%%%%%%%%%%%%%%%
T1(count,count)=(4^(count-1)*T1(count,1)-T1(count-1,1))/(4^(count-1)-1);

%%%%%%%%%%%%%%%%%%%%%
while(abs(T1(count,count)-T1(count-1,count-1))>=3*dx)  
    count=count+1;
    n=2*n;
    h=h/2;
%%%%%%%%count==3%%%%%%%
Fsum=0;
for ii=1:n
    Fsum=Fsum+f1(a+(2*ii-1)*h);    
end
T1(count,1)=T1(count-1,1)/2+h*Fsum;
%%%%%%%%%%%%%%%%%%%%%
for ii=2:count
T1(count,ii)=(4^(ii-1)*T1(count,ii-1)-T1(count-1,ii-1))/(4^(ii-1)-1);
%T1(3,2)=(4^1*T1(3,1)-T1(2,1))/(4^1-1);
%T1(3,3)=(4^2*T1(3,2)-T1(2,2))/(4^2-1);
end

end
%II=T1
T1,
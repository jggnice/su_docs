% p.266,  p.268
a=1.2;b=0.8;
sx=0.6;sy=0.4;
n=100000;m=0;z=0; 
x=unifrnd(0,1.2,1,n);
y=unifrnd(0,0.8,1,n);
for i=1:n  
   u=0;
   if x(i)^2/a^2+y(i)^2/b^2<=1
      u=exp(-0.5*(x(i)^2/sx^2+y(i)^2/sy^2));
      z=z+u;
      m=m+1;
   end
end
P=4*a*b*z/2/pi/sx/sy/n

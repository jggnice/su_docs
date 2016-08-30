x=0:0.1:1;y=1./(1+x);z1=trapz(x,y)
x1=0:0.05:1;y1=1./(1+x1);z2=trapz(x1,y1)
format long
z3=quad('1./(1+x)',0,1,10e-4)
z4=quad('1./(1+x)',0,1,10e-6)
z5=quad('1./(1+x)',0,1,10e-4)
z6=quad('1./(1+x)',0,1,10e-6)
format short

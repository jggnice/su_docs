clear;clc
t1=0:pi/40:pi/2 ;
x=2*cos(t1)-cos(2*t1);
y=2*sin(t1)-sin(2*t1);
s1=trapz(y,x+1);
plot(x,y) 
hold on
t2=pi:-pi/40:pi/2;
x1=1+2*cos(t2);
y1=2*sin(t2);plot(x1,y1,'r') 
s2=trapz(y1,x1+1);
hold off
grid on
s=(s1-s2)*2
std=5*pi-8
abs(s-std)








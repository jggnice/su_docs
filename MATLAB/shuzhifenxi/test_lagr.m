%_____test_lagr.m______
clc;clear;
x1=-4:2:4;%4
x2=[-5:-3 0 3:5];%6
x3=[-5:-2 0 2:5];%8
x4=-5:5;%10
x_dot=-5:0.01:5;
y0=1./(1+x_dot.*x_dot);
y1=lagr(x1,1./(1+x1.*x1),x_dot);
y2=lagr(x2,1./(1+x2.*x2),x_dot);
y3=lagr(x3,1./(1+x3.*x3),x_dot);
y4=lagr(x4,1./(1+x4.*x4),x_dot);

figure(1);plot(x_dot,y1,x_dot,y0);xlabel('-4:2:4');title('4 times')
figure(2);plot(x_dot,y2,x_dot,y0);xlabel('[-5:-3 0 3:5]');title('6 times')
figure(3);plot(x_dot,y3,x_dot,y0);xlabel('[-5:-2 0 2:5]');title('8 times')
figure(4);plot(x_dot,y4,x_dot,y0);xlabel('-5:5');title('10 times')

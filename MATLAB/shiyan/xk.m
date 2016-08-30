clc;clear;
x(1,1)=0.5;x(2,1)=0.5;
for k=1:20
x(1,k+1)=exp(-x(1,k));
x(2,k+1)=x(2,k)-(x(2,k)-exp(-x(2,k)))/(1+x(2,k));
end

plot((1:21)',[x(1,:)' x(2,:)']);grid;legend('e^{-x_k}','newton')
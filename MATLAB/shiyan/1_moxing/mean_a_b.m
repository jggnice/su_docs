a0=1;b0=1/sqrt(2);
a(1)=(a0+b0)/2;
b(1)=sqrt(a0*b0);
for n=2:10
a(n)=(a(n-1)+b(n-1))/2;
b(n)=sqrt(a(n-1)*b(n-1));
end
figure(1);plot(1:10,[a;b]);
grid;legend('a_k','b_k');

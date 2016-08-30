 for ii=1:50000
x=unifrnd(2,5,[1 6]);
y(ii)=std(x,1);
end
hist(y,50000)
[z(2,:),z(1,:)]=hist(y,50000);
zz(1)=0;
for ii=2:50000
    zz(ii)=zz(ii-1)+y(ii);
end
plot(1:50000,zz/50000);
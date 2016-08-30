%离散点的函数逼近
%_____bijin.m______
ii = 0: 10;
xi=-1+0.2*ii;
fi=1./(1+25*xi.*xi);
figure(1);plot(xi,fi,'ro');hold on
AI=zeros(4,4);
BI=zeros(4,1);
vector=zeros(6,11);

for jj1=1:7
    for jj2=1:11
        vector(jj1,jj2)=xi(jj2)^(jj1-1);
    end
end

for jj1=1:4
    for jj2=1:4
        AI(jj1,jj2)=sum(vector(jj1+jj2-1,:));
    end
end

for jj1=1:4
    BI(jj1)=sum(fi.*vector(jj1,:));
end
aa=AI\BI;
xx=-1:0.01:1;
yy=aa(1)+aa(2)*xx+aa(3)*xx.^2+aa(4)*xx.^3;

plot(xx,yy);
title(['这个曲线方程是：',num2str(aa(1)),'+',num2str(aa(2)),'*x+',num2str(aa(3)),'*x^2+',num2str(aa(4)),'*x^3']);
hold off
clear all;
%newsboy
a=0.8;b=1;c=0.75;
q=(b-a)/(b-c);
r=[3 9 13 22 32 35 20 15 8 2];
rr=sum(r);
x=110:20:290;  % 需求量取表中小区间的中点
rbar=r*x'/rr   % 计算均值
s=sqrt(r*(x.^2)'/rr-rbar^2)    % 计算标准差
n=norminv(q,rbar,s)            % 用逆概率分布计算n

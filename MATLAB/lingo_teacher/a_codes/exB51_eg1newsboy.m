clear all;
%newsboy
a=0.8;b=1;c=0.75;
q=(b-a)/(b-c);
r=[3 9 13 22 32 35 20 15 8 2];
rr=sum(r);
x=110:20:290;  % ������ȡ����С������е�
rbar=r*x'/rr   % �����ֵ
s=sqrt(r*(x.^2)'/rr-rbar^2)    % �����׼��
n=norminv(q,rbar,s)            % ������ʷֲ�����n

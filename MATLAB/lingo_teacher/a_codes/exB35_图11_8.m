%��ѧ��ѧʵ��|2  ʵ��10|11  �����ܶȺ��� p.244|260
x = 0:0.1:20;
y1=chi2pdf(x,5);
y2=chi2pdf(x,10);

plot(x,y1,x,y2,'linewidth',2)	!ͼ10.8|11.8


% ָ���ֲ���������׼��ķֲ����� (������)
n = 6;  %��������
m = 50000;  %�ظ���
lamda = 2;
a = exprnd(2,n,m);
b=std(a);
b1=sort(b);
p = [0.001:0.001:1];
pm=50:50:50000;
clear a;
x =b1(pm);
plot(x,p);			


m=length(x);
x1 = x(3:m)-x(1:(m-2));
pdfx = p(2:(m-1));
pdf = 0.002/2./x1;
plot(pdfx,pdf)

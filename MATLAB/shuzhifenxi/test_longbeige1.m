%���ι�ʽ�Է����������
clc;clear;
format long
a=0;b=1;dx=1e-6;
n=1;h=(b-a)/2;

T0=h*(f1(a)+f1(b));
%��δ�Է�����
count=0;

Fsum=0;
for ii=1:n
    Fsum=Fsum+f1(a+(2*ii-1)*h);
    T=T0/2+h*Fsum;
end

while(abs(T-T0)>=3*dx)  
    n=2*n;
    %�Է�1��
count = count + 1;
    h=h/2;
    T0=T;
Fsum=0;
for ii=1:n
    Fsum=Fsum+f1(a+(2*ii-1)*h);    
end  
T=T0/2+h*Fsum;

end
'����ֵ'
disp(T),
'�Էִ���'
disp(count),
'������'
disp(n),
'Standard=pi/4='
disp(pi/4),
format short

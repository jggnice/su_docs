% p.6-7  ��1.2.1  ѪҺ�ƾ�����  ��ͼ��
 t = [1 2 3 4 5 6 7 8 9 10 11 12];
 c = [82 77 68 51 41 38 35 28 25 18 15 12];
% plot(t, c,'+',t,c),grid on, 
plot(t, c,'+')
xlabel('t');ylabel('c(t)');    %p.6ͼ1.1

plot(t, log(c),'+')
xlabel('t');ylabel('lnc(t)');  %p.6ͼ1.2

% p.7 ��1.2.1�����     lnc = ln k0 - kt, b0 = lnc0, b1 = -k
y = log(c)';
n = size(y,1);   % ȡy������
x = [ones(n,1),t'];
b = regress(y,x);   
c0 = exp(b(1));
k = -b(2);
[c0,k]

c1 = c0*exp(-k*t);

plot(t, c,'+',t,c1)
xlabel('t');ylabel('c(t)');  %p.6ͼ1.3


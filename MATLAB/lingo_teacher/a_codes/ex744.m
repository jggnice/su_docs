% p.6-7  ��1.2.1  ѪҺ�ƾ�����  ��ͼ�� = ��7.4.4(p.154)
 t = [1 2 3 4 5 6 7 8 9 10 11 12]';
 c = [82 77 68 51 41 38 35 28 25 18 15 12]';


% p.7 ��1.2.1�����     lnc = ln k0 - kt, b0 = lnc0, b1 = -k
y = log(c);
n = size(y,1);   % ȡy������
f = [t,ones(n,1)];
aa=inv(f'*f)*f'*y
a=f\y
z=aa-a      %��� 
k = -a(1),c0 = exp(a(2))


a3 = polyfit(t,y,1)

k = -a3(1),c0 = exp(a3(2))
yerror = polyval(a3,t) -y    % �в�


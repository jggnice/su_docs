% ��ѧ��ѧʵ��2  p.103
H=hilb(5),
h=rats(H),
b=ones(5,1);
x=H\b;      	% x�� Hx = b �Ľ�
b(5)=1.1;	% b���Ŷ�0.1,db = (0 0 0 0 .1)
x1=H\b;		% x1�� Hx = b+db �Ľ�
[x,x1],

t11=norm(H)	  % H��    2-����
t12=norm(inv(H))  % H�����2-����
n1=cond(H,1),	  % H��1-������
n2=cond(H,2),	  % H��2-��������n2 =tl1*tl2
n=rcond(H),	  % H��1-�������ĵ�����n = 1/n2
n1*n

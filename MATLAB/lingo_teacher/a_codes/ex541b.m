% 大学数学实验2  p.103
H=hilb(5),
h=rats(H),
b=ones(5,1);
x=H\b;      	% x是 Hx = b 的解
b(5)=1.1;	% b加扰动0.1,db = (0 0 0 0 .1)
x1=H\b;		% x1是 Hx = b+db 的解
[x,x1],

t11=norm(H)	  % H的    2-范数
t12=norm(inv(H))  % H的逆的2-范数
n1=cond(H,1),	  % H的1-条件数
n2=cond(H,2),	  % H的2-条件数，n2 =tl1*tl2
n=rcond(H),	  % H的1-条件数的倒数，n = 1/n2
n1*n

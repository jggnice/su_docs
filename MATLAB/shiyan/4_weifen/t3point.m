%���㹫ʽ
n=12;h=2;S=pi*5^2;
y=[305 298 290 265 246 225 207 189 165 148 130 114];
df=zeros(1,12);
for k=2:n-1
df(k)=(y(k+1)-y(k-1))/(2*h);
end
df(1)=(-3*y(1)+4*y(2)-y(3))/(2*h);
df(n)=(3*y(n)-4*y(n-1)+y(n-2))/(2*h);
df=S.*df;


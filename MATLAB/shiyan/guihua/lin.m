c=[160 130 220 170 140 130 190 150 190 200 230 0];
A2=[ones(1,4),zeros(1,8);
    zeros(1,4),ones(1,4),zeros(1,4);
    zeros(1,10),1,0];
A0=[eye(4),eye(4),eye(4)];A0(4,12)=0;
A1=[A0;A0];
b1=[80 140 30 50 -30 -70 -10 -10];
b2=[50 60 50];
v1=[zeros(1,12)];
[x,fv]=linprog(c,A1,b1,A2,b2,v1);
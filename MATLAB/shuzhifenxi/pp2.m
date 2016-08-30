function P=pp2(P,r1,r2,coef)
P(r2,:)=P(r2,:)+coef * P(r1,:);
end
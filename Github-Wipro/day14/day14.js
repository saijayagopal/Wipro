const btn = document.getElementById("btn");
const userDiv = document.getElementById("user");

btn.onclick = async () => {
    const res = await fetch("https://randomuser.me/api/");
    const data = await res.json();
    const u = data.results[0];

    userDiv.innerHTML = `
        <img src="${u.picture.large}">
        <h3>${u.name.first} ${u.name.last}</h3>
        <p>${u.email}</p>
    `;
};

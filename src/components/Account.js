import React from "react";
import jwt from 'jwt-decode';



const Account = () => {
    var profile = localStorage.getItem('token');

    var decode = jwt(profile);
    console.log(decode);
    return(
        <div className="App">{decode.name}</div>
    )
};

export default Account;
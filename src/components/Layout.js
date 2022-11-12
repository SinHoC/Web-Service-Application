import { Outlet, Link } from 'react-router-dom';

const Layout = () => {
    return(
        <>
        <nav>
            <u1>
                <li>
                    <Link to='/'>Home</Link>
                </li>
                <li>
                    <Link to='/order'>Order</Link>
                </li>
                <li>
                    <Link to='/account'>Account</Link>
                </li>
            </u1>
        </nav>

        <Outlet />
        </>
    )
};
export default Layout;
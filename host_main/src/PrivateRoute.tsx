import { Navigate } from "react-router-dom";
import { useSelector } from 'react-redux';


export default function PrivateRoute({children}) {
  const { session, loading, error } = useSelector((state) => state.session);

    if (!session) {
        return <Navigate to="/" state={{ from: history.location }} />
    }

    return children;
}
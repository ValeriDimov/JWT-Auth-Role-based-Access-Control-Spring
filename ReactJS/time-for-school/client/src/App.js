import { Routes, Route, useNavigate } from 'react-router-dom';
import { useState, useEffect } from 'react';

import { AuthProvider } from './contexts/AuthContext';
import { offerServiceFactory } from './services/offerService';

import { Header } from "./components/Header/Header";
import { Home } from "./components/Home/Home";
import { Login } from './components/Login/Login';
import { Register } from './components/Register/Register';
import { Logout } from './components/Logout/Logout';
import { SchoolList } from './components/SchoolList/SchoolList';
import { SchoolDetails } from './components/SchoolDetails/SchoolDetails';
import { AddOffer } from './components/AddOffer/AddOffer';
import { OfferList } from './components/OfferList/OfferList';

function App() {
	const navigate = useNavigate();
    const [offers, setOffers] = useState([]);
    const offerService = offerServiceFactory(); //auth.accessToken

    useEffect(() => {
        offerService.getAll()
            .then(result => {
                setOffers(result)
            })
    }, []);

    const onCreateOfferSubmit = async (data) => {
        const newOffer = await offerService.create(data);

        setOffers(state => [...state, newOffer]);

        navigate('/offers/all');
    };

    const onOfferEditSubmit = async (values) => {
        const result = await offerService.edit(values._id, values);

        setOffers(state => state.map(x => x._id === values._id ? result : x))

        navigate(`/offers/${values._id}`);
    }

  return (
    <AuthProvider>
		<Header />
			<Routes>
				<Route path="/" element={<Home />} />
				<Route path='/login' element={<Login />} />
				<Route path='/logout' element={<Logout />} />
				<Route path='/register' element={<Register />} />
				<Route path='/schools/all' element={<SchoolList />} />
				<Route path='/schools/:schoolId' element={<SchoolDetails />} />
				<Route path='/offers/add' element={<AddOffer onCreateOfferSubmit={onCreateOfferSubmit}/>} />
				<Route path='/offers/all' element={<OfferList offers={offers}/>} />


			</Routes>
    </AuthProvider>
  );
}

export default App;

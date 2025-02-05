import React, { FC, ReactElement, useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { Carousel, Typography } from "antd";

import { selectProducts } from "../../../redux-toolkit/perfumes/perfumes-selector";
import { fetchProductsByIds } from "../../../redux-toolkit/perfumes/perfumes-thunks";
import { resetProductsState } from "../../../redux-toolkit/perfumes/perfumes-slice";
import ProductCardsSliderItem from "./ProductCardsSliderItem/ProductCardsSliderItem";
import "./ProductCardsSlider.css";

export const perfumesIds = [26, 43, 46, 106, 34, 76, 82, 85, 27, 39, 79, 86];

const ProductCardsSlider: FC = (): ReactElement => {
    const dispatch = useDispatch();
    const perfumes = useSelector(selectProducts);

    useEffect(() => {
        // GraphQL example
        // dispatch(fetchProductsByIdsQuery(perfumesId));
        dispatch(fetchProductsByIds(perfumesIds));

        return () => {
            dispatch(resetProductsState());
        };
    }, []);

    return (
        <div className={"perfume-cards-slider"}>
            <Typography.Title level={3} className={"perfume-cards-slider-title"}>
                PERSONALLY RECOMMENDED
            </Typography.Title>
            <Carousel>
                <ProductCardsSliderItem perfumes={perfumes.slice(0, 4)} />
                <ProductCardsSliderItem perfumes={perfumes.slice(4, 8)} />
                <ProductCardsSliderItem perfumes={perfumes.slice(8, 12)} />
            </Carousel>
        </div>
    );
};

export default ProductCardsSlider;

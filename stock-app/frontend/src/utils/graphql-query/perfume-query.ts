export const getAllProductsByQuery = `
    {
        perfumes {
            id
            perfumeTitle
            perfumer
            price
            filename
            perfumeRating
        }
    }
`;

export const getProductByQuery = (id: string) => `
    {
        perfume(id: ${id}) {
            id
            perfumeTitle
            perfumer
            year
            country
            perfumeGender
            fragranceTopNotes
            fragranceMiddleNotes
            fragranceBaseNotes
            filename
            price
            volume
            type
            perfumeRating
            reviews {
                id
                author
                message
                date
                rating
            }
        }
    }
`;

export const geProductsByIdsQuery = (ids: Array<number>) => `
    {
        perfumesIds(ids: [${ids}]) {
            id
            perfumeTitle
            perfumer
            price
            filename
            perfumeRating
        }
    }
`;
